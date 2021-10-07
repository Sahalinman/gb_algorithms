package lesson2.homework.constants;

public enum Company {

    LENUVO("Lenuvo", 1),
    ASOS("Asos", 2),
    MAC_NOTE("MacNote", 3),
    ESER("Eser", 4),
    XAMIOU("Xamiou", 5);

    // Название компании
    private String companyName;
    // Пусть это будет популярность компании, её приоритет в сортировке
    private Integer priority;

    Company(String companyName, int priority) {
        this.companyName = companyName;
        this.priority = priority;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPriority() {
        return priority;
    }

    public static String getCompanyNameByPriority(int priority) {
        for (Company name : Company.values()) {
            if (name.getPriority() == priority) {
                return name.getCompanyName();
            }
        }
        return null;
    }

    public static Integer getPriorityByCompanyName(String companyName) {
        for (Company name : Company.values()) {
            if (name.getCompanyName().equals(companyName)) {
                return name.getPriority();
            }
        }
        return null;
    }
}
