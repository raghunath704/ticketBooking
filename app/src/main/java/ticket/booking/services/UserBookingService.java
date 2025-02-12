package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_FILE_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

    //throws IOException means that htis class when instanciated, can throw exception,
    //so when we create object, we will put it in try catch to handle exceptions
    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        loadUsers();
    }

    //when the user is not logged in
    public UserBookingService() throws IOException {
        loadUsers();
    }

    //this function loads all the users to 'users'
    public void loadUsers() throws IOException{
        File users = new File(USER_FILE_PATH);
        //deserialize json to list, TypeReference is used in runtime
        objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_FILE_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
    // json -=> Object (User) -=> desirealize
    // Object (User) --> json --> Serialize

    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelBooking (String ticketId){
        //complete this function
        return Boolean.FALSE;
    }

    public List<Train> getTrains(String source, String destination){

    }

}