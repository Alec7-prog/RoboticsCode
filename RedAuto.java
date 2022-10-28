package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RedAuto", group = "Robot")
public class RedAuto extends LinearOpMode{

    private DcMotor FrontRightMotor = null;
    private DcMotor FrontLeftMotor = null;
    private DcMotor BackLeftMotor = null;
    private DcMotor BackRightMotor = null;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){
        FrontRightMotor = hardwareMap.get(DcMotor.class, "RF");
        FrontLeftMotor = hardwareMap.get(DcMotor.class, "LF");
        BackLeftMotor = hardwareMap.get(DcMotor.class, "LR");
        BackRightMotor = hardwareMap.get(DcMotor.class, "RR");

        FrontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        FrontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        BackRightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive() && (runtime.seconds() < 2.5)){
            FrontLeftMotor.setPower(-1);
            BackLeftMotor.setPower(1);
            FrontRightMotor.setPower(-1);
            BackRightMotor.setPower(1);
        }
    }
}