package com.example.fragpractice2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    ImageSelectionCallback callback;

    //context 객체가 어떤 액티비티 위에 올라갈 때마다 그 액티비티가 전달됨
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //ImageselectionCallback을 구현하는게 맞다면 액티비티가 아래의 객체로 넘어오게됨
        if(context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                MainActivity activity = (MainActivity) getActivity();
                activity.onImageSelected(0);
                메인액티비티에서만 사용한다면 이렇게 적어도 상관없지만
                만약 다른 액티비티에서 사용하게 된다면 계속해서 코드를 수정해줘야하므로 아래와같이 작성하는 것이 좋음
                 */

                if(callback !=null) {
                    callback.onImageSelected(0);
                }
            }
        });

        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback !=null){
                    callback.onImageSelected(1);
                }
            }
        });

        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback !=null){
                    callback.onImageSelected(2);
                }
            }
        });

        return rootView;
    }
}
