/**
 * Created by srikanth.kannan on 1/3/17.
 */
public class Enumeration {

    public static void main(String[] args) {
        System.out.println("\"campaign_id\" to enum ->" + filterNames.getByName("campaign_i"));
        System.out.println("filterNames.CAMPAIGN_ID.name() - > " + filterNames.CAMPAIGN_ID.name());
        System.out.println("filterNames.CAMPAIGN_ID.getName() - > " + filterNames.CAMPAIGN_ID.getName());
    }

    private static enum filterNames {
        CAMPAIGN_ID("campaign_id"),
        CAMPAIGN_PK("campaign_pk"),
        PLACEMENT_ID("placement_id"),
        PLACEMENT_PK("placement_pk"),
        EVENT("event"),
        ACCOUNT_ID("account_id");

        private filterNames(String name) {
            this.name = name;
        }

        private String name;

        private String getName() {
            return this.name;
        }

        public static filterNames getByName(String name) {
            for (filterNames filter : values()) {
                if (filter.getName().equals(name)) {
                    return filter;
                }
            }

            return null;
        }

        @Override
        public String toString() { // to ensure the String representation is consistent
            return name;
        }

    }

    public <E extends Enum<E>> boolean isEnum(String value, Class<E> enumClass){
        boolean isEnum = false;
        for(E e : enumClass.getEnumConstants()){
            if(e.name().equals(value)){
                return true;
            }
        }
        return false;
    }
}