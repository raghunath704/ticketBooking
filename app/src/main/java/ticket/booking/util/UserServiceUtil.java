package ticket.booking.util;

import org.mindrot.jbcrypt.BCrypt;

//this util file is for hashing password;
public class UserServiceUtil
{

    //encryption of password
    public static String hashPassword(String plainPassword) {

        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
    //decryption of passwprd
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
