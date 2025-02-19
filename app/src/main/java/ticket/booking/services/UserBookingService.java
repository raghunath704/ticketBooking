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
import java.util.Scanner;

public class UserBookingService {
    private User user;
    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();
    private final String USER_FILE_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

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
        userList=objectMapper.readValue(users, new TypeReference<List<User>>() {
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
            return true;
        }catch (IOException ex){
            return false;
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
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ticket id to cancel");
        ticketId = s.next();

        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }
        String finalTicketId = ticketId;
        boolean removed=user.getTicketsBooked().removeIf(Ticket -> Ticket.getTicketId().equals(finalTicketId));
        if (removed) {
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return Boolean.TRUE;
        }else{
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }
    }



}