package com.online.reteroex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.online.reteroex.model.Comment;
import com.online.reteroex.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mLog;
    private Button BtnRun,BtnClear;
    MyWebService mWebService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mWebService = MyWebService.retrofit.create(MyWebService.class);
    }

    private void initView() {

        mLog = findViewById(R.id.text);
        BtnRun = findViewById(R.id.btnRun);
        BtnClear = findViewById(R.id.btnClear);
        BtnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runcode(view);
            }
        });
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLog.setText("");
            }
        });
    }

    public void runcode(View view){
      //  getPosts();
          getComments();
    }

    private void getComments() {
        Call<List<Comment>> call = mWebService.getComments(5,"id","desc");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(response.isSuccessful()){
                    ShowComment(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void ShowComment(List<Comment> body) {

        for(Comment comment:body){
            mLog.append("id :"+comment.getId()+"\n");
            mLog.append("PostId :"+comment.getPostId()+"\n");
            mLog.append("user :"+comment.getName()+"\n");
            mLog.append("email :"+comment.getEmail()+"\n");
            mLog.append("body :"+comment.getBody()+"\n");
        }

    }

    private void getPosts() {
        Call<List<Post>> call=  mWebService.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(response.isSuccessful()){
                    System.out.println("-----------success-----------"+response.body().toString());

                    for (Post post:response.body()){
                        ShowPost(post);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    private void ShowPost(Post post) {
        mLog.append("UserId :"+post.getUserId()+"\n");
        mLog.append("id :"+post.getId()+"\n");
        mLog.append("title :"+post.getTitle()+"\n");
        mLog.append("body :"+post.getText()+"\n");
    }
}