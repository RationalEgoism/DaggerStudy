package study.rationalegoism.daggerstudy.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class RandomUsers {

    private List<Result> results = null;

    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public RandomUsers(List<Result> results) {

        this.results = results;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("results", results)
                .append("info", info)
                .toString();
    }
}
