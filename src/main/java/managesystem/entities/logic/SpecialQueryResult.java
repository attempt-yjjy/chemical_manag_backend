package managesystem.entities.logic;

import java.io.Serializable;

public class SpecialQueryResult implements Serializable {
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SpecialQueryResult{" +
                "count=" + count +
                '}';
    }
}
