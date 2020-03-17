/**
 * Supplier
 */
public class Supplier {
    private String name;
    private String phone;
    private String adress;
    private String zipCode;

    /**
     * 
     * @param name
     * @param phone
     * @param adress
     * @param zipCode
     */
    public Supplier(String name, String phone, String adress, String zipCode) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.zipCode = zipCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}