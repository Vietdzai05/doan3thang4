package doanjava;
import java.io.*;
import java.util.*;


class Food {
    private String name;
    private double price;
    private String type;

    public Food(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}

public class DoAnJava {
    private static ArrayList<Food> foods = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
        	System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║        ╔══════════════════════════════╗        ║");
            System.out.println("║        ║         QUẢN LÝ ĐỒ ĂN        ║        ║");
            System.out.println("║        ╚══════════════════════════════╝        ║");
            System.out.println("║                                                ║");
            System.out.println("║ 1. Thêm đồ ăn                                  ║");
            System.out.println("║ 2. Hiển thị danh sách đồ ăn                    ║");
            System.out.println("║ 3. Tìm kiếm đồ ăn                              ║");
            System.out.println("║ 4. Xoá đồ ăn                                   ║");
            System.out.println("║ 5. Sửa thông tin đồ ăn                         ║");
            System.out.println("║ 6. Sắp xếp danh sách đồ ăn                     ║");
            System.out.println("║ 7. Thống kê đồ ăn                              ║");
            System.out.println("║ 8. Thoát                                       ║");
            System.out.println("║                                                ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addFood(scanner);
                    break;
                case 2:
                    displayFoods();
                    break;
                case 3:
                    searchFood(scanner);
                    break;
                case 4:
                    deleteFood(scanner);
                    break;
                case 5:
                    updateFood(scanner);
                    break;
                case 6:
                    sortFoods();
                    break;
                
                case 7:
                    statisticFoods();
                    break;
                case 8:
                    System.out.println("Chương trình kết thúc.Tạm Biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);
        scanner.close();
    }

    private static void addFood(Scanner scanner) {
        System.out.println("Nhập thông tin đồ ăn:");
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Giá tiền: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        System.out.print("Loại đồ ăn: ");
        String type = scanner.nextLine();
        Food food = new Food(name, price, type);
        foods.add(food); 
        System.out.println("Đã thêm đồ ăn thành công.");
    }

    private static void displayFoods() {
        System.out.println("Danh sách đồ ăn:");
        for (Food food : foods) {
        	 System.out.println("Tên: " + food.getName() + ", Giá tiền: " + food.getPrice() + ", Loại đồ ăn: " + food.getType());
        }
    }

    private static void searchFood(Scanner scanner) {
        System.out.print("Nhập tên đồ ăn cần tìm kiếm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.println("Đồ ăn được tìm thấy:");
                System.out.println("Tên: " + food.getName() + ", Giá tiền: " + food.getPrice() + ", Loại đồ ăn: " + food.getType());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đồ ăn có tên \"" + name + "\".");
        }
    }
    private static void deleteFood(Scanner scanner) {
        System.out.print("Nhập tên đồ ăn cần xoá: ");
        String name = scanner.nextLine();
        Iterator<Food> iterator = foods.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Food food = iterator.next();
            if (food.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Đã xoá đồ ăn \"" + name + "\".");
                deleted = true;
            }
        }
        if (!deleted) {
            System.out.println("Không tìm thấy đồ ăn có tên \"" + name + "\".");
        }
    }
    private static void updateFood(Scanner scanner) {
        System.out.print("Nhập tên đồ ăn cần sửa: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.println("Nhập thông tin mới cho đồ ăn \"" + name + "\":");
                System.out.print("Tên: ");
                String newName = scanner.nextLine();
                System.out.print("Giá tiền: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Loại đồ ăn: ");
                String newType = scanner.nextLine();
                // Cập nhật thông tin của đối tượng Food trong danh sách
                food = new Food(newName, newPrice, newType);
                foods.set(i, food); // Cập nhật lại đối tượng trong danh sách
                System.out.println("Đã cập nhật thông tin cho đồ ăn \"" + name + "\".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đồ ăn có tên \"" + name + "\".");
        }
    }
    

  
}