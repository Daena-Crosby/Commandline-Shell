package EmailSystem;

import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class AuthService {
    private static final String USER_FILE = "C://Users//daena//OneDrive//Personal Projects//EmailSystem//users.txt";

    // Hashes a password using SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    // Checks if an email already exists
    private static boolean emailExists(String email) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1 && userDetails[1].equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Registers a new user
    public static boolean registerUser(String username, String email, String password) {
        try {
            if (emailExists(email)) {
                return false;
            }

            String hashedPassword = hashPassword(password);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
                writer.write(username + "," + email + "," + hashedPassword);
                writer.newLine();
            }
            return true;
        } 
        catch (IOException e) 
        {
            return false;
        }
    }

    public static boolean loginUser(String email, String hashedPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[1].trim().equals(email) && parts[2].trim().equals(hashedPassword)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}