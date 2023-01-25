package datebook;

public class TypeOfTask {

    protected enum Type {
        WORK("Рабочая"),
        PERSONAL("Личная");

        public static Type findByWrite(String setType) {
            for (Type type : values()) {
                if (type.getSetType().equalsIgnoreCase(setType)){
                    return type;
                }
            }
            return null;
        }

        private final String setType;

        Type(String setType) {
            this.setType = setType;
        }

        public String getSetType() {
            return setType;
        }

        @Override
        public String toString() {
            return setType;
        }

    }



}
