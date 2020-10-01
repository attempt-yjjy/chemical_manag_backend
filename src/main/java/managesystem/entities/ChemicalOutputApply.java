package managesystem.entities;

import java.io.Serializable;
import java.util.Date;

public class ChemicalOutputApply implements Serializable {
    private Integer id;
    private String ch_name;
    private String ch_type;
    private Integer count;
    private Date output_time;
    private String proposer;
    private Integer pro_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getOutput_time() {
        return output_time;
    }

    public void setOutput_time(Date output_time) {
        this.output_time = output_time;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "ChemicalOutputApply{" +
                "id=" + id +
                ", ch_name='" + ch_name + '\'' +
                ", ch_type='" + ch_type + '\'' +
                ", count=" + count +
                ", output_time=" + output_time +
                ", proposer='" + proposer + '\'' +
                ", pro_id=" + pro_id +
                '}';
    }
}
