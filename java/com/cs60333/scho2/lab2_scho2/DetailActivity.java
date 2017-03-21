package com.cs60333.scho2.lab2_scho2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samcho on 2/20/17.
 */

public class DetailActivity extends AppCompatActivity {

    static final int CAMERA_REQUEST = 1;

    @Override
    public void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        Team example = (Team) getIntent().getSerializableExtra("teams");

        String opponentName = example.getTeamName();
        String opponentLogo = example.getTeamLogo();
        String opponentMascot = example.getTeamMascot();
        String opponentRecord = example.getTeamRecord();
        String finalScore = example.getScore();
        String Record = example.getNdRecord();
        String dates = example.getLongDate();

        TextView team = (TextView) this.findViewById(R.id.detailOpponentSchool);
        team.setText(opponentName);
        TextView teamMascot = (TextView) this.findViewById(R.id.detailOpponentMascot);
        teamMascot.setText(opponentMascot);
        TextView teamRecord = (TextView) this.findViewById(R.id.detailOpponentRecord);
        teamRecord.setText(opponentRecord);
        TextView score = (TextView) this.findViewById(R.id.detailFinalScore);
        score.setText(finalScore);
        TextView record = (TextView) this.findViewById(R.id.detailRecord);
        record.setText(Record);
        TextView date = (TextView) this.findViewById(R.id.detailDate);
        date.setText(dates);
        ImageView teamLogo = (ImageView) this.findViewById(R.id.detailOpponentLogo);
        int resID = getResources().getIdentifier(opponentLogo, "drawable", getPackageName());
        teamLogo.setImageResource(resID);

        Button b = (Button) findViewById(R.id.detailCamera);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivity(cameraIntent);

//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//                String pictureName = getPictureName();
//                File imageFile = new File(pictureDirectory, pictureName);
//                Uri pictureUri = Uri.fromFile(imageFile);
//                cameraIntent.putExtra("extraOutput", MediaStore.EXTRA_OUTPUT);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
    }
//    private String getPictureName() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        String timestamp = sdf.format(new Date());
//        return "BestMoments" + timestamp + ".jpg";
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imgView = (ImageView) findViewById(R.id.detailPic);
            imgView.setImageBitmap(imageBitmap);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK) {
//            if (requestCode == CAMERA_REQUEST) {
//               // Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
//                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//
//                String pictureDirectoryPath = pictureDirectory.getPath();
//                Uri imageUri = Uri.parse(pictureDirectoryPath);
//                InputStream inputStream;
//                try {
//                    inputStream = getContentResolver().openInputStream(imageUri);
//
//                    Bitmap image = BitmapFactory.decodeStream(inputStream);
//                    ImageView imgView = (ImageView) findViewById(R.id.detailPic);
//                    imgView.setImageBitmap(image);
//
//                }
//                catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                }
//            }
//        }
//    }
}
