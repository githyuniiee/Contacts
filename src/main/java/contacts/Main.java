package contacts;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 비즈니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택해주세요: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //비즈니스 연락처 추가
                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("전화번호를 입력하세요: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("회사명을 입력하세요: ");
                    String company = scanner.nextLine();

                    BusinessContact businessContact = new BusinessContact(name, phoneNumber, company);
                    addressBook.saveContact(businessContact);
                    break;

                case 2:
                    // 개인 연락처 추가
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.nextLine();
                    System.out.print("전화번호를 입력하세요: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("관계를 입력하세요: ");
                    String relationship = scanner.nextLine();

                    PersonalContact personalContact = new PersonalContact(name, phoneNumber, relationship);
                    addressBook.saveContact(personalContact);
                    break;

                case 3:
                    // 연락처 출력
                    System.out.println("연락처 목록:");
                    boolean found = false;

                    for (Contact contact : addressBook.displayContacts()) {
                        System.out.print("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber());

                        if (contact instanceof BusinessContact) {
                            System.out.println(", 회사명: " + ((BusinessContact) contact).getCompany());
                        } else {
                            System.out.println(", 관계: " + ((PersonalContact) contact).getRelationship());
                        }
                        found = true;
                    }

                    if (!found) {
                        System.out.println("연락처가 비어있습니다.");
                    }
                    System.out.println();
                    break;

                case 4:
                    // 연락처 검색
                    System.out.print("검색할 이름을 입력하세요: ");
                    String searchName = scanner.nextLine();

                    Contact foundContact = addressBook.searchContact(searchName);

                    if (foundContact != null) {
                        System.out.print("이름: " + foundContact.getName() + ", 전화번호: " + foundContact.getPhoneNumber());

                        if (foundContact instanceof BusinessContact) {
                            System.out.println(", 회사명: " + ((BusinessContact) foundContact).getCompany());
                        } else {
                            System.out.println(", 관계: " + ((PersonalContact) foundContact).getRelationship());
                        }
                    } else {
                        System.out.println("연락처를 찾을 수 없습니다.");
                    }

                    System.out.println();
                    break;


                case 5:
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
