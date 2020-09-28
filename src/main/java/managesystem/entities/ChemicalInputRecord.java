package managesystem.entities;

import java.io.Serializable;
import java.util.Date;

public class ChemicalInputRecord implements Serializable {
    private Integer id;
    private Date input_time;
    private Integer useful_life;
    private Integer count;
    private Integer cabinet;
    private String input_person;
    private String approver;
    private String unit;
    private String ch_name;
    private String ch_type;

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

    public Integer getUseful_life() {
        return useful_life;
    }

    public void setUseful_life(Integer useful_life) {
        this.useful_life = useful_life;
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

    public String getCh_name() {
        return ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public String getCh_type() {
        return ch_type;
    }

    public void setCh_type(String ch_type) {
        this.ch_type = ch_type;
    }

    @Override
    public String toString() {
        return "Chemical{" +
                "id=" + id +
                ", input_time=" + input_time +
                ", useful_life=" + useful_life +
                ", count=" + count +
                ", cabinet=" + cabinet +
                ", input_person='" + input_person + '\'' +
                ", approver='" + approver + '\'' +
                ", unit='" + unit + '\'' +
                ", ch_name='" + ch_name + '\'' +
                ", ch_type='" + ch_type + '\'' +
                '}';
    }
}
