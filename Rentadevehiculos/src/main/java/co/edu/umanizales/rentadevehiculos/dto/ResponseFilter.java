package co.edu.umanizales.rentadevehiculos.dto;

public class ResponseFilter {
    package co.edu.rentcar.dto;

    public class ResponseFilter {
        private String type;
        private int count;

        public ResponseFilter(String type, int count) {
            this.type = type;
            this.count = count;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count =count;
        }
    }
}
