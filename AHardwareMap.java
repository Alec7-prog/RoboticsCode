package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
public class AHardwareMap {

    private LinearOpMode myOpMode = null;

    public DcMotor topLeftMotor;
    public DcMotor topRightMotor;
    public DcMotor bottomLeftMotor;
    public DcMotor bottomRightMotor;
    public Servo   mainHand = null;

    public static final double MID_SERVO = 0.5;
    public static final double ARM_UP_POWER = .45;
    public static final double ARM_DOWN_POWER = .45;

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        topLeftMotor = myOpMode.hardwareMap.get(DcMotor.class, "top_LeftMotor");
        topRightMotor = myOpMode.hardwareMap.get(DcMotor.class, "top_RighMotor");
        bottomLeftMotor = myOpMode.hardwareMap.get(DcMotor.class, "bottom_LeftMotor");
        bottomRightMotor = myOpMode.hardwareMap.get(DcMotor.class, "bottom_RightMotor");

        topRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        mainHand = myOpMode.hardwareMap.get(Servo.class, "mainHand");
        mainHand.setPosition(MID_SERVO);
    }
}
