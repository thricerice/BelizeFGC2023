package org.firstinspires.ftc.teamcode;

import android.telephony.CellIdentity;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "BelizeFGC2023")

public class BelizeFGC2023 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        BelFGCINI2023 belFGC2023 = new BelFGCINI2023(this.hardwareMap, this.telemetry, this);


        waitForStart();



        while (opModeIsActive()){
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            double rightPower;
            double leftPower;
            double rightliftpower;
            double leftliftpower;

            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Send calculated power to wheels
            belFGC2023.LeftDrive.setPower(leftPower);
            belFGC2023.RightDrive.setPower(rightPower);

            //Lift Control
            rightliftpower = Range.clip(-gamepad2.left_stick_y, -.5 , .5);
            leftliftpower = Range.clip(-gamepad2.left_stick_y, -.5 , .5);

            belFGC2023.RightLift.setPower(rightliftpower);
            belFGC2023.LeftLift.setPower(leftliftpower);

            //gate control
            if (gamepad2.left_bumper){
                belFGC2023.Gate.setPosition(1);
            } else if (gamepad2.right_bumper) {
                belFGC2023.Gate.setPosition(0);
            }

            //intake control
            if (gamepad2.circle){
                belFGC2023.RightIntake.setPower(1);
                belFGC2023.LeftIntake.setPower(1);
            } else if (gamepad2.cross){
                belFGC2023.RightIntake.setPower(0);
                belFGC2023.RightIntake.setPower(0);
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();

        }
    }
}

