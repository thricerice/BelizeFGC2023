package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BelFGCINI2023 {

    //initializing the drive train motors
    public  DcMotorEx LeftDrive;
    public  DcMotorEx RightDrive;
    //initializing motors
    public DcMotorEx RightLift;
    public DcMotorEx LeftLift;
    public DcMotorEx RightIntake;
    public DcMotorEx LeftIntake;

    //initializing servos
    public Servo Gate;

    // Don't touch these
    public Telemetry telemetry;
    public OpMode opMode;

    public BelFGCINI2023(HardwareMap hwMap, Telemetry telemetry, OpMode opMode){

        this.telemetry = telemetry;
        this.opMode = opMode;

        //Defining Motors and servos
        LeftDrive = (DcMotorEx)hwMap.dcMotor.get("BL");
        RightDrive = (DcMotorEx)hwMap.dcMotor.get("BR");
        RightLift = (DcMotorEx)hwMap.dcMotor.get("RLIFT");
        LeftLift = (DcMotorEx)hwMap.dcMotor.get("LLIFT");
        RightIntake = (DcMotorEx)hwMap.dcMotor.get("NomNomR");
        LeftIntake = (DcMotorEx)hwMap.dcMotor.get("NomNomL");
        Gate = hwMap.servo.get("GATE");

        //Defining Sensors

        //Reverse motors if needed
        RightDrive.setDirection(DcMotor.Direction.REVERSE);
        LeftDrive.setDirection(DcMotor.Direction.FORWARD);
        RightLift.setDirection(DcMotor.Direction.FORWARD);
        LeftLift.setDirection(DcMotor.Direction.REVERSE);
        RightIntake.setDirection(DcMotor.Direction.FORWARD);
        LeftIntake.setDirection(DcMotorSimple.Direction.FORWARD);
        // sets what the motor does when you don't tell it to do anything
        LeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        LeftIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }




}
