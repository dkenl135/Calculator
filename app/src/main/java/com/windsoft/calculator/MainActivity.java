package com.windsoft.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.BounceAnimation;
import com.easyandroidanimations.library.FlipVerticalAnimation;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBackspace, mClear, mEqual, mPlus, mMinus, mMultiply, mDivision;
    private Button mNum[] = new Button[10];
    private TextView mFirstNum, mLastNum, mEqualNum;
    private long mIndex;
    private int mCalculationCondtion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variableDefine();

        setOnClickListener();

    }


    private void variableDefine() {
        mNum[0] = (Button) findViewById(R.id.ActivityMain_Zero);
        mNum[1] = (Button) findViewById(R.id.ActivityMain_One);
        mNum[2] = (Button) findViewById(R.id.ActivityMain_Two);
        mNum[3] = (Button) findViewById(R.id.ActivityMain_Three);
        mNum[4] = (Button) findViewById(R.id.ActivityMain_Four);
        mNum[5] = (Button) findViewById(R.id.ActivityMain_Five);
        mNum[6] = (Button) findViewById(R.id.ActivityMain_Six);
        mNum[7] = (Button) findViewById(R.id.ActivityMain_Seven);
        mNum[8] = (Button) findViewById(R.id.ActivityMain_Eight);
        mNum[9] = (Button) findViewById(R.id.ActivityMain_Nine);

        mBackspace = (Button) findViewById(R.id.ActivityMain_Backspace);
        mClear = (Button) findViewById(R.id.ActivityMain_Clear);
        mEqual = (Button) findViewById(R.id.ActivityMain_Equal);
        mPlus = (Button) findViewById(R.id.ActivityMain_Plus);
        mMinus = (Button) findViewById(R.id.ActivityMain_Minus);
        mMultiply = (Button) findViewById(R.id.ActivityMain_Multiply);
        mDivision = (Button) findViewById(R.id.ActivityMain_Division);

        mFirstNum = (TextView) findViewById(R.id.ActivityMain_FirstNum);
        mLastNum = (TextView) findViewById(R.id.ActivityMain_LastNum);
        mEqualNum = (TextView) findViewById(R.id.ActivityMain_EqualNum);
    }

    private void setOnClickListener() {
        for (int i = 0; i < 10; i++) {
            mNum[0].setOnClickListener(this);
            mNum[1].setOnClickListener(this);
            mNum[2].setOnClickListener(this);
            mNum[3].setOnClickListener(this);
            mNum[4].setOnClickListener(this);
            mNum[5].setOnClickListener(this);
            mNum[6].setOnClickListener(this);
            mNum[7].setOnClickListener(this);
            mNum[8].setOnClickListener(this);
            mNum[9].setOnClickListener(this);
        }

        mBackspace.setOnClickListener(this);
        mClear.setOnClickListener(this);
        mEqual.setOnClickListener(this);
        mPlus.setOnClickListener(this);
        mMinus.setOnClickListener(this);
        mMultiply.setOnClickListener(this);
        mDivision.setOnClickListener(this);
    }


    private void calculation(int num) {
        BounceAnimation animation = new BounceAnimation(mNum[num]);
        animation.setBounceDistance(20);
        animation.setDuration(300);

        animation.setNumOfBounces(5);
        animation.animate();

        if (mCalculationCondtion == 0) {
            if (mFirstNum.length() < 9) {
                if (mFirstNum.length() == 0) {
                    if (num != 0) {
                        mFirstNum.append(String.valueOf(num));
                    }
                }
                else {
                    int a = Integer.parseInt(mFirstNum.getText().toString());
                    if (a == 0) {
                        mFirstNum.setText("");
                    }
                    mFirstNum.append(String.valueOf(num));
                }

                mEqualNum.setText("");
            }
        }
        else {
            if (mLastNum.length() < 9) {
                if (mLastNum.length() == 0) {
                    if (num != 0) {
                        mLastNum.append(String.valueOf(num));
                    }
                }
                else {
                    int a = Integer.parseInt(mFirstNum.getText().toString());
                    if (a == 0) {
                        mLastNum.setText("");
                    }
                    mLastNum.append(String.valueOf(num));
                }
            }
        }
    }


    private void deleteNum() {
        if (mCalculationCondtion == 0 && mFirstNum.length() != 0) {
            String a = mFirstNum.getText().toString();
            int b = Integer.parseInt(a);
            b /= 10;
            mFirstNum.setText(String.valueOf(b));
        } else if (mCalculationCondtion == 1 && mFirstNum.length() != 0) {
            String a = mLastNum.getText().toString();
            int b = Integer.parseInt(a);
            b /= 10;
            mLastNum.setText(String.valueOf(b));
        }

        if (mEqualNum.length() > 0) {
            String c = mEqualNum.getText().toString();
            int d = Integer.parseInt(c);
            d /= 10;
            mEqualNum.setText(String.valueOf(d));
        }
    }

    private void clearNum() {
        mFirstNum.setText("");
        mLastNum.setText("");
        mEqualNum.setText("");
        mCalculationCondtion = 0;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ActivityMain_Zero:
                calculation(0);
                break;

            case R.id.ActivityMain_One:
                calculation(1);
                break;

            case R.id.ActivityMain_Two:
                calculation(2);
                break;

            case R.id.ActivityMain_Three:
                calculation(3);
                break;

            case R.id.ActivityMain_Four:
                calculation(4);
                break;

            case R.id.ActivityMain_Five:
                calculation(5);
                break;

            case R.id.ActivityMain_Six:
                calculation(6);
                break;

            case R.id.ActivityMain_Seven:
                calculation(7);
                break;

            case R.id.ActivityMain_Eight:
                calculation(8);
                break;

            case R.id.ActivityMain_Nine:
                calculation(9);
                break;

            case R.id.ActivityMain_Plus:
                BounceAnimation animation = new BounceAnimation(mPlus);
                animation.setBounceDistance(20);
                animation.setDuration(300);

                animation.setNumOfBounces(5);
                animation.animate();

                mCalculationCondtion = 1;
                if (mEqualNum.length() > 0) {
                    mFirstNum.setText(mEqualNum.getText().toString());
                    mEqualNum.setText("");
                }
                else if (mLastNum.length() > 0) {
                    mFirstNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) + Long.parseLong(mLastNum.getText().toString())));
                    mLastNum.setText("");
                }
                break;

            case R.id.ActivityMain_Minus:
                BounceAnimation animation2 = new BounceAnimation(mMinus);
                animation2.setBounceDistance(20);
                animation2.setDuration(300);

                animation2.setNumOfBounces(5);
                animation2.animate();

                mCalculationCondtion = 2;
                if (mEqualNum.length() > 0) {
                    mFirstNum.setText(mEqualNum.getText().toString());
                    mEqualNum.setText("");
                }
                else if (mLastNum.length() > 0) {
                    mFirstNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) - Long.parseLong(mLastNum.getText().toString())));
                    mLastNum.setText("");
                }
                break;

            case R.id.ActivityMain_Multiply:
                BounceAnimation animation3 = new BounceAnimation(mMultiply);
                animation3.setBounceDistance(20);
                animation3.setDuration(300);

                animation3.setNumOfBounces(5);
                animation3.animate();

                mCalculationCondtion = 3;
                if (mEqualNum.length() > 0) {
                    mFirstNum.setText(mEqualNum.getText().toString());
                    mEqualNum.setText("");
                }
                else if (mLastNum.length() > 0) {
                    mFirstNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) * Long.parseLong(mLastNum.getText().toString())));
                    mLastNum.setText("");
                }
                break;

            case R.id.ActivityMain_Division:
                BounceAnimation animation4 = new BounceAnimation(mDivision);
                animation4.setBounceDistance(20);
                animation4.setDuration(300);

                animation4.setNumOfBounces(5);
                animation4.animate();

                mCalculationCondtion = 4;

                if (mEqualNum.length() > 0) {
                    mFirstNum.setText(mEqualNum.getText().toString());
                    mEqualNum.setText("");
                }
                else if (mLastNum.length() > 0) {
                    mFirstNum.setText(String.valueOf(Double.parseDouble(mFirstNum.getText().toString()) / Double.parseDouble(mLastNum.getText().toString())));
                    mLastNum.setText("");
                }
                break;

            case R.id.ActivityMain_Clear:
                BounceAnimation animation5 = new BounceAnimation(mClear);
                animation5.setBounceDistance(20);
                animation5.setDuration(300);

                animation5.setNumOfBounces(5);
                animation5.animate();
                clearNum();

                break;

            case R.id.ActivityMain_Backspace:
                BounceAnimation animation6 = new BounceAnimation(mBackspace);
                animation6.setBounceDistance(20);
                animation6.setDuration(300);

                animation6.setNumOfBounces(5);
                animation6.animate();
                deleteNum();
                break;


            case R.id.ActivityMain_Equal:
                BounceAnimation animation7 = new BounceAnimation(mEqual);
                animation7.setBounceDistance(20);
                animation7.setDuration(300);

                animation7.setNumOfBounces(5);
                animation7.animate();

                FlipVerticalAnimation anim = new FlipVerticalAnimation(mFirstNum);
                anim.setDuration(800);
                anim.animate();

                anim = new FlipVerticalAnimation(mLastNum);
                anim.setDuration(800);

                final FlipVerticalAnimation anim2 = new FlipVerticalAnimation(mEqualNum);
                anim2.setDuration(1600);
                anim2.animate();

                anim.setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {


                        switch (mCalculationCondtion) {
                            case 1:
                                mEqualNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) + Long.parseLong(mLastNum.getText().toString())));
                                break;

                            case 2:
                                mEqualNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) - Long.parseLong(mLastNum.getText().toString())));
                                break;

                            case 3:
                                mEqualNum.setText(String.valueOf(Long.parseLong(mFirstNum.getText().toString()) * Long.parseLong(mLastNum.getText().toString())));
                                break;

                            case 4:
                                mEqualNum.setText(String.valueOf(Double.parseDouble(mFirstNum.getText().toString()) / Double.parseDouble(mLastNum.getText().toString())));
                                break;
                        }
                        mFirstNum.setText("");
                        mLastNum.setText("");

                        mCalculationCondtion = 0;
                    }
                });

                anim.animate();

                break;
        }
    }
}
