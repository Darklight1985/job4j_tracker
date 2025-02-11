package ru.job4j.ex;
import static java.util.Objects.isNull;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user: users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
                break;
            }
        }
        if (isNull(rsl)) {
            throw new UserNotFoundException("user not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
       if (user.isValid() || user.getUsername().length() < 3) {
           throw new UserInvalidException("user is not valid");
       }
       return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
       try {
           User user = findUser(users, "Petr Arsentev");
           if (validate(user)) {
               System.out.println("This user has an access");
           }
       } catch (UserInvalidException ei) {
           ei.printStackTrace();
       } catch (UserNotFoundException eu) {
           eu.printStackTrace();
       }
    }
}