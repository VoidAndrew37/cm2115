package uk.ac.rgu.cm2115;

public class Cancel implements CommandPattern{
    
    Status status;

    public Cancel(Status newStatus) {
        status = newStatus;
    }

    @Override
    public void execute() {
        status.cancel();
    }
    


}


