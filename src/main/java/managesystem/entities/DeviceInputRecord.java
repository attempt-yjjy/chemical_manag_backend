package managesystem.entities;

import java.io.Serializable;
import java.util.Date;

public class DeviceInputRecord implements Serializable {
    private Integer id;
    private Date input_time;
    private Integer count;
    private Integer cabinet;
    private String input_person;
    private String approver;
    private String unit;
    private String de_name;
    private String de_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCabinet() {
        return cabinet;
    }

    public void setCabinet(Integer cabinet) {
        this.cabinet = cabinet;
    }

    public String getInput_person() {
        return input_person;
    }

    public void setInput_person(String input_person) {
        this.input_person = input_person;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDe_name() {
        return de_name;
    }

    public void setDe_name(String de_name) {
        this.de_name = de_name;
    }

    public String getDe_type() {
        return de_type;
    }

    public void setDe_type(String de_type) {
        this.de_type = de_type;
    }

    @Override
    public String toString() {
        return "DeviceInputRecord{" +
                "id=" + id +
                ", input_time=" + input_time +
                ", count=" + count +
                ", cabinet=" + cabinet +
                ", input_person='" + input_person + '\'' +
                ", approver='" + approver + '\'' +
                ", unit='" + unit + '\'' +
                ", de_name='" + de_name + '\'' +
                ", de_type='" + de_type + '\'' +
                '}';
    }
}
