package com.online.reteroex.model;

public class Register {

        private String name;
        private String email;
        private long mobile;
        private String dob;
        private String doctype;
        private int docid;
        private String API_KEY ;
        private String status;
        private String message;

    public Register(String name, String email, long mobile, String dob, String doctype, int docid,String API_KEY,String status,String message) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.doctype = doctype;
        this.docid = docid;
        this.API_KEY=API_KEY;
        this.status = status;
        this.message = message;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getMobile() {
            return mobile;
        }

        public void setMobile(int mobile) {
            this.mobile = mobile;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getDoctype() {
            return doctype;
        }

        public void setDoctype(String doctype) {
            this.doctype = doctype;
        }

        public int getDocid() {
            return docid;
        }

        public void setDocid(int docid) {
            this.docid = docid;
        }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

