package nl.cofano.schedulerapp.scheduler;

public class TODOItem {
    private String description;
    private Integer assignee;
    private Boolean markedAsFinished;

    @java.beans.ConstructorProperties({"description","assignee", "markedAsFinished"})
    public TODOItem( String description, Integer assignee,Boolean markedAsFinished) {

        this.description = description;
        this.assignee = assignee;
        this.markedAsFinished = markedAsFinished;
    }

    public TODOItem(){
    }

    public String getDescription() {
        return description;
    }

    public int getAssignee() {
        return assignee;
    }
}
