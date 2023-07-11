package repository;

public class PackageBox {
   private long id;
    private String DepartureAddress;
    private String DesttinationAddress;
    private String State;
    private String DateOfReceipt;
    private String DataOfLastStatus;
    private long Weight;

    public PackageBox(long id, String departureAddress, String desttinationAddress, String state, String dateOfReceipt, String lastStatus, long Weight) {
        this.id = id;
        DepartureAddress = departureAddress;
        DesttinationAddress = desttinationAddress;
        this.State = state;
        DateOfReceipt = dateOfReceipt;
        DataOfLastStatus = lastStatus;
        this.Weight = Weight;

    }

    public PackageBox() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartureAddress() {
        return DepartureAddress;
    }

    public void setDepartureAddress(String departureAddress) {
        DepartureAddress = departureAddress;
    }

    public String getDesttinationAddress() {
        return DesttinationAddress;
    }

    public void setDesttinationAddress(String desttinationAddress) {
        DesttinationAddress = desttinationAddress;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getDateOfReceipt() {
        return DateOfReceipt;
    }

    public void setDateOfReceipt(String dateOfReceipt) {
        DateOfReceipt = dateOfReceipt;
    }

    public String getLastStatus() {
        return DataOfLastStatus;
    }

    public void setLastStatus(String lastStatus) {
        DataOfLastStatus = lastStatus;
    }

    public long getWeight() {
        return Weight;
    }
    public void setWeight(long weight) {
        this.Weight = weight;
    }

    @Override
    public String toString() {
        return "PackageBox{" +
                "id=" + id +
                ", DepartureAddress='" + DepartureAddress + '\'' +
                ", DesttinationAddress='" + DesttinationAddress + '\'' +
                ", State='" + State + '\'' +
                ", DateOfReceipt='" + DateOfReceipt + '\'' +
                ", DataOfLastStatus='" + DataOfLastStatus + '\'' +
                ", Weight=" + Weight +
                '}';
    }

}

