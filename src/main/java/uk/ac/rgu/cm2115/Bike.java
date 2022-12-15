package uk.ac.rgu.cm2115;

// Bike Interface to get the enum for BrakeType, FrameSize, and SuspensionType
public interface Bike {
    BrakeType getBrakeType();
    int getFrameSize();
    Suspension getSuspension();
}
