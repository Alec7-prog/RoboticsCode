package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeleOp", group = "Robot")
@Disabled
public class MyTeleOp extends LinearOpMode {

    private LinearOpMode myOpMode = null;

    public DcMotor topLeftMotor;
    public DcMotor topRightMotor;
    public DcMotor bottomLeftMotor;
    public DcMotor bottomRightMotor;
    public Servo leftHand = null;
    public Servo rightHand = null;

    @Override
    public void runOpMode() throws InterruptedException {

        AHardwareMap hardwareMap = new AHardwareMap();

        waitForStart();
        topLeftMotor = myOpMode.hardwareMap.get(DcMotor.class, "top_LeftMotor");
        topRightMotor = myOpMode.hardwareMap.get(DcMotor.class, "top_RighMotor");
        bottomLeftMotor = myOpMode.hardwareMap.get(DcMotor.class, "bottom_LeftMotor");
        bottomRightMotor = myOpMode.hardwareMap.get(DcMotor.class, "bottom_RightMotor");

        topRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftHand = myOpMode.hardwareMap.get(Servo.class, "leftHand");
        leftHand.setPosition(0);
        rightHand = myOpMode.hardwareMap.get(Servo.class, "rightHand");
        rightHand.setPosition(0);

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            topLeftMotor.setPower(frontLeftPower);
            topRightMotor.setPower(backLeftPower);
            bottomLeftMotor.setPower(frontRightPower);
            bottomRightMotor.setPower(backRightPower);
        }
    }
}