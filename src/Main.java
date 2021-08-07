import Modules.Employee;
import Modules.Product;
import enums.Category;
import enums.Position;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(
                "Kevin Melan",
                26,
                true,
                LocalDate.of(1994, 12, 9),
                "MercadoLibre",
                Position.BACKEND_DEVELOPER,
                4100000
                )
        );
        employees.add(new Employee(
                "David Muñoz",
                38,
                true,
                LocalDate.of(1983, 10, 9),
                "Merqueo",
                Position.QA,
                8000000
                )
        );
        employees.add(new Employee(
                "Camilo Muñoz",
                30,
                true,
                LocalDate.of(1991, 1, 19),
                "Globant",
                Position.FRONTEND_DEVELOPER,
                7500000
                )
        );
        employees.add(new Employee(
                "Eduardo Yisus",
                27,
                false,
                LocalDate.of(1994, 1, 20),
                "Globant",
                Position.BACKEND_DEVELOPER,
                7500000
                )
        );

        List<Product> products = new ArrayList<>();

        products.add(new Product("2345", "Computador", 345.67, Category.TECH));
        products.add(new Product("6578", "YuGiOh Cards", 10, Category.CHILDREN));
        products.add(new Product("8790", "Celular", 150.56, Category.TECH));
        products.add(new Product("6565", "Manzanas", 1, Category.FOODS));
        products.add(new Product("8888", "Camisa", 13, Category.CLOTHES));

        // FUNCTIONAL PROGRAMMING

        // FOREACH
        // employees.forEach(em -> System.out.println(em.getName()));
        // employees.forEach(System.out::println);

        // Filter
        List<Employee> employeesFiltered = employees.stream()
                                            .filter(em -> em.getAge() > 30)
                                            .collect(Collectors.toList());

        // MAP
        List<Employee> employeesMap = employees.stream()
                                        .map(em -> incrementSalaryToEmployee(em, 15))
                                        .collect(Collectors.toList());

        // SORTED
        Comparator<Employee> byNameDes = (Employee a, Employee b) -> b.getName().compareTo(a.getName());
        List<Employee> employeesSorted = employees.stream()
                                            .sorted(byNameDes)
                                            .collect(Collectors.toList());

        // ANY MATCH
        Predicate<Employee> startWithPredicate = em -> em.getName().startsWith("c");
        boolean response = employees.stream()
                                .anyMatch(startWithPredicate);

        // MATCH
        boolean responseTwo = employees.stream()
                                    .allMatch(em -> em.getName().length() > 10);

        // NO MATCH
        boolean responseThree = employees.stream()
                                    .noneMatch(em -> em.getName().length() > 100);

        // LIMIT / SKIP
        int pageSize = 2;
        int pageNumber = 1;
        Comparator<Employee> bySalaryAsc = (Employee a, Employee b) -> Double.compare(b.getSalary(), a.getSalary());
        List<Employee> employeesPaginated = employees.stream()
                                                .sorted(bySalaryAsc)
                                                .skip(pageSize * pageNumber)
                                                .limit(pageSize)
                                                .collect(Collectors.toList());

        // GROUP BY
        Map<Category, List<Product>> productsGrouping = products.stream()
                    .collect(Collectors.groupingBy(Product::getCategory));

        // Get sum of all products
        DoubleSummaryStatistics statistics = products.stream()
                                                .collect(Collectors.summarizingDouble(Product::getPrice));

        // Get sum of all products with tech category
        DoubleSummaryStatistics statistics2 = products.stream()
                                                .filter(p -> p.getCategory() == Category.TECH && p.getCategory() == Category.FOODS)
                                                .collect(Collectors.summarizingDouble(Product::getPrice));

        // REDUCE
        double total = products.stream()
                            .map(Product::getPrice)
                            .reduce(Double::sum).get();
    }

    public static Employee incrementSalaryToEmployee(@NotNull Employee employee, double increment) {
        final double salary = employee.getSalary();
        employee.setSalary(((salary * increment) / 100) + salary);
        return employee;
    }
}
