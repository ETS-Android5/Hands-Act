package com.handshands.handsaast;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class offersadapter extends RecyclerView.Adapter<offersadapter.mh> {
    ArrayList<offersinheret>list;
    Context context;
    Dialog dialog;
ImageView background,image;
TextView off,det;
CardView cardView;
DatabaseReference reference,reference2;
ArrayList<sendrequest>list2;
    public offersadapter(ArrayList<offersinheret> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public mh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rawoffer,parent,false);

        return new mh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final mh holder, final int position) {
holder.per.setText(list.get(position).getPercentage());
        holder.off.setText(list.get(position).getOffer());
        holder.det.setText(list.get(position).getDetails());
        holder.code.setText(list.get(position).getCode());
        Picasso.get().load(list.get(position).getBackground()).into(holder.background);
        Picasso.get().load(list.get(position).getImage()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String s = FirebaseAuth.getInstance().getCurrentUser().getUid();
        list2 = new ArrayList<>();
        reference2 = FirebaseDatabase.getInstance().getReference("offers").child("requeststaked").child(s);
        reference2.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    sendrequest sendrequest = new sendrequest();
                    sendrequest.setOffer(dataSnapshot.child("offer").getValue().toString());
                    sendrequest.setTake(dataSnapshot.child("take").getValue().toString());
                    sendrequest.setUid(dataSnapshot.child("uid").getValue().toString());
                    sendrequest.setCode(dataSnapshot.child("code").getValue().toString());
                    list2.add(sendrequest);
                    if (sendrequest.getUid().equals(s) && sendrequest.getCode().equals(list.get(position).getCode())) {
                        context.startActivity(new Intent(context, myapolo.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

            dialog = new Dialog(context);
            dialog.setContentView(R.layout.confirmmessage);
            cardView = dialog.findViewById(R.id.confirmbutton);
            background = dialog.findViewById(R.id.confirmbackground);
            image = dialog.findViewById(R.id.confirmimage);
            off = dialog.findViewById(R.id.confirmoffer1);
            det = dialog.findViewById(R.id.confirmoffer2);
            Picasso.get().load(list.get(position).getBackground()).into(background);
            Picasso.get().load(list.get(position).getImage()).into(image);
            off.setText(list.get(position).getOffer());
            det.setText(list.get(position).getDetails());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(context).setIcon(R.drawable.thumbnail2).setTitle("Note !!").setMessage("You have to be near the cashier to confirm your offer !!").setPositiveButton("confirm", null).show();
                    alertDialog.setCancelable(true);
                    Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            boolean connected=false;
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
                            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                                String t = "taken";
                                reference = FirebaseDatabase.getInstance().getReference("offers").child("requeststaked").child(s);
                                sendrequest sendrequest = new sendrequest(list.get(position).getOffer(), t, s, list.get(position).getCode());
                                reference.child(s+list.get(position).getCode()).setValue(sendrequest);
                                Intent intent = new Intent(context, offers.class);
                                context.startActivity(intent);
                                connected = true;
                            }
                            else{
                                connected = false;
                            Toast.makeText(context, "You need to be online to take this offer !", Toast.LENGTH_SHORT).show();
                        }}
                    });

                }
            });
            dialog.show();



    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mh extends RecyclerView.ViewHolder{
        ImageView background,image;
        TextView per,off,det,code;
        public mh(@NonNull View itemView) {
            super(itemView);
            per=itemView.findViewById(R.id.offer);
            off=itemView.findViewById(R.id.myoffer1);
            det=itemView.findViewById(R.id.myoffer2);
            background=itemView.findViewById(R.id.backk);
            image=itemView.findViewById(R.id.itemphoto);
            code=itemView.findViewById(R.id.code);

        }
    }

}
