package lesson2.homework;

public enum CompanyName {

    LENUVO("Lenuvo", 1),
    ASOS("Asos", 2),
    MAC_NOTE("MacNote", 3),
    ESER("Eser", 4),
    XAMIOU("Xamiou", 5);

    private String companyName;
    private Integer priority;

    CompanyName(String companyName, int priority) {
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
        for (CompanyName name : CompanyName.values()) {
            if (name.getPriority() == priority) {
                return name.getCompanyName();
            }
        }
        return null;
    }

    public static Integer getPriorityByCompanyName(String companyName) {
        for (CompanyName name : CompanyName.values()) {
            if (name.getCompanyName().equals(companyName)) {
                return name.getPriority();
            }
        }
        return null;
    }
}
