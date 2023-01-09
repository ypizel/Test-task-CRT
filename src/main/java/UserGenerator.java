import java.util.Random;

public class UserGenerator {

        private static Random random = new Random();

        public static User getNewUser() {
            return new User("example" + random.nextInt(10_000_000) + "@mail.ru", "12345");
        }
        public static User getWithoutEmail() {
            return new User("", "qwerty");
        }

        public static User getWithoutPassword() {
            return new User("example" + random.nextInt(10_000_000) + "@mail.ru", "");
        }

    }

