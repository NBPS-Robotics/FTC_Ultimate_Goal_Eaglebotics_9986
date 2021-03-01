package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.VoltageSensor;
@Disabled
@TeleOp(name = "MainTeleOp", group = "OpModes")
public class MainTeleOp extends LinearOpMode {
    private VoltageSensor ExpansionHub1_VoltageSensor;
    float RstickX;
    float RstickY;
    double LStick;
    double LT;
    double RT;
    @Override
    public void runOpMode() {

        Robot.leftFront = hardwareMap.dcMotor.get("leftFront");
        Robot.leftRear = hardwareMap.dcMotor.get("leftRear");
        Robot.rightFront = hardwareMap.dcMotor.get("rightFront");
        Robot.rightRear = hardwareMap.dcMotor.get("rightRear");
        Robot.MLeftShooter = hardwareMap.dcMotor.get("MLeftShooter");
        Robot.MRightShooter = hardwareMap.dcMotor.get("MRightShooter");
        Robot.MIntake = hardwareMap.dcMotor.get("MIntake");
        Robot.MArm = hardwareMap.dcMotor.get("MArm");
        ExpansionHub1_VoltageSensor = hardwareMap.voltageSensor.get("Expansion Hub 2");
        Robot.LClaw = hardwareMap.servo.get("LClaw");
        Robot.RClaw = hardwareMap.servo.get("RClaw");
        Robot.Cam = hardwareMap.servo.get("Cam");
        Robot.Hopper = hardwareMap.servo.get("Hopper");
        Robot.Cam.setPosition(0.2);
        Robot.Hopper.setPosition(0.94);
        Robot.openArm();
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                // Put loop blocks here.
                telemetry.update();
                Robot.Hopper.setPosition(0.94);
                Robot.MechanumDriveControl(gamepad1.right_stick_x*Constants.turnPower, gamepad1.right_stick_y,  gamepad1.left_stick_x);
                if (gamepad1.y) {
                    Robot.shooterOn(Constants.powerConstant);
                }
                if (gamepad1.a) {
                    Robot.shooterOff();
                }
                if (gamepad1.left_bumper){ //code for speed change
                    Robot.SpeedControl(0.6);


                }
                else{
                    Robot.SpeedControl(1);
                }
                if (gamepad1.x){
                    Robot.ShootGoal(ExpansionHub1_VoltageSensor.getVoltage());

                }
                if (gamepad1.b){
                    Robot.ShootOne(ExpansionHub1_VoltageSensor.getVoltage());

                }
                if (gamepad1.right_bumper){ //code for shooting the power shots
                    Robot.PowerShot(ExpansionHub1_VoltageSensor.getVoltage());
                }


                if (gamepad1.dpad_down){ // code for the arm
                    Robot.MArm.setPower(-1);
                }
                else if (gamepad1.dpad_up){
                    Robot.MArm.setPower(1);
                }
                else{
                    Robot. MArm.setPower(0);
                }
                if (gamepad1.dpad_right){
                    Robot.closeArm();
                }
                if (gamepad1.dpad_left){
                    Robot.openArm();
                }

                Robot.MIntake.setPower(-gamepad1.left_stick_y);

            }

        }

    }


}