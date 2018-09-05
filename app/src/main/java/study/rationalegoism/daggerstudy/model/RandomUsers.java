package study.rationalegoism.daggerstudy.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class RandomUsers {

    private List<Result> resuls = null;

    private Info info;



    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public RandomUsers(List<Result> resuls) {

        this.resuls = resuls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("resuls", resuls)
                .append("info", info)
                .toString();
    }
}
