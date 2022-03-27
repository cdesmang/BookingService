public class Friend {
    
    private String email;
    private Date dob;
    private String address;
    private String username;
    private String fullName;
    
    
    public Friend(String fullName, String username, String email, Date DOB, String address) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.dob = DOB;
        this.address = address;
    }

    /**
     * @return Returns the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Returns the date of birth
     */
    public String getDOB() {
        return dob.toString();
    }

    /**
     * @return Returns the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return Returns the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Returns the full name
     */
    public String getFullName() {
        return fullName;
    }
}
