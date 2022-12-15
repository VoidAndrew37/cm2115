package uk.ac.rgu.cm2115;

public class Save implements CommandPattern {

    Status status;

    public Save(Status newStatus) {
        status = newStatus;
    }

    @Override
    public void execute() {
        status.save();
    }
    


}
