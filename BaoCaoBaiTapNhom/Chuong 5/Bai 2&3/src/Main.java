import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BÀI 2: SEARCH INTERFACE

interface Search {
    Book search(List<Book> books, String isbn);
}

class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class LinearSearch implements Search {

    @Override
    public Book search(List<Book> books, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }

        return null;
    }
}

class BinarySearch implements Search {

    @Override
    public Book search(List<Book> books, String isbn) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Book middleBook = books.get(middle);

            int compareResult = middleBook.getIsbn().compareToIgnoreCase(isbn);

            if (compareResult == 0) {
                return middleBook;
            } else if (compareResult < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }
}

// BÀI 3: ADDRESS VALIDATOR

interface AddressValidator {
    boolean validateStreet(String street);
    boolean validateCity(String city);
    boolean validatePostalCode(String postalCode);
    boolean validateFullAddress(String street, String city, String postalCode);
}

class USAAddress implements AddressValidator {

    @Override
    public boolean validateStreet(String street) {
        return street != null && street.trim().length() >= 5;
    }

    @Override
    public boolean validateCity(String city) {
        return city != null && city.matches("[a-zA-Z\\s]+");
    }

    @Override
    public boolean validatePostalCode(String postalCode) {
        return postalCode != null && postalCode.matches("\\d{5}");
    }

    @Override
    public boolean validateFullAddress(String street, String city, String postalCode) {
        return validateStreet(street)
                && validateCity(city)
                && validatePostalCode(postalCode);
    }
}

class VNAddress implements AddressValidator {

    @Override
    public boolean validateStreet(String street) {
        return street != null && street.trim().length() >= 5;
    }

    @Override
    public boolean validateCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            return false;
        }

        String lowerCity = city.toLowerCase();

        return lowerCity.contains("hà nội")
                || lowerCity.contains("ha noi")
                || lowerCity.contains("hồ chí minh")
                || lowerCity.contains("ho chi minh")
                || lowerCity.contains("đà nẵng")
                || lowerCity.contains("da nang")
                || lowerCity.contains("cần thơ")
                || lowerCity.contains("can tho");
    }

    @Override
    public boolean validatePostalCode(String postalCode) {
        return postalCode != null && postalCode.matches("\\d{5}");
    }

    @Override
    public boolean validateFullAddress(String street, String city, String postalCode) {
        return validateStreet(street)
                && validateCity(city)
                && validatePostalCode(postalCode);
    }
}

public class Main {
    public static void main(String[] args) {

        // Test bài 2

        List<Book> books = new ArrayList<>();

        books.add(new Book("B003", "Clean Code", "Robert C. Martin"));
        books.add(new Book("B001", "Java Core", "John Smith"));
        books.add(new Book("B002", "Data Structures", "Mark Lee"));
        books.add(new Book("B004", "Design Patterns", "GoF"));

        Search linearSearch = new LinearSearch();

        Book result1 = linearSearch.search(books, "B002");

        System.out.println("Kết quả tìm kiếm tuần tự:");
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Không tìm thấy sách");
        }

        books.sort(Comparator.comparing(Book::getIsbn));

        Search binarySearch = new BinarySearch();

        Book result2 = binarySearch.search(books, "B004");

        System.out.println("\nKết quả tìm kiếm nhị phân:");
        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Không tìm thấy sách");
        }

        Book result3 = linearSearch.search(books, "B999");

        System.out.println("\nTìm sách không tồn tại:");
        if (result3 != null) {
            System.out.println(result3);
        } else {
            System.out.println("Không tìm thấy sách");
        }


        // Test bài 3

        AddressValidator usaAddress = new USAAddress();

        boolean usaResult = usaAddress.validateFullAddress(
                "123 Main Street",
                "New York",
                "10001"
        );

        System.out.println("\nKiểm tra địa chỉ Hoa Kỳ:");
        System.out.println(usaResult ? "Địa chỉ hợp lệ" : "Địa chỉ không hợp lệ");


        AddressValidator vnAddress = new VNAddress();

        boolean vnResult = vnAddress.validateFullAddress(
                "12 Nguyễn Trãi",
                "Hồ Chí Minh",
                "70000"
        );

        System.out.println("\nKiểm tra địa chỉ Việt Nam:");
        System.out.println(vnResult ? "Địa chỉ hợp lệ" : "Địa chỉ không hợp lệ");
    }
}