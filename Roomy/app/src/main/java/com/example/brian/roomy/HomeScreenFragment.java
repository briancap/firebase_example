package com.example.brian.roomy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.brian.roomy.Firebase.Tenant;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Fragment that will be added to MainActivity
 */

public class HomeScreenFragment extends Fragment {
    private FirebaseDatabase    mFirebaseDatabase;
    private DatabaseReference   mTenetDbReference;
    private ChildEventListener  mChildEventListener;

    Button testButton;

    public HomeScreenFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mTenetDbReference = mFirebaseDatabase.getReference().child(getString(R.string.top_level_tenant));
        mChildEventListener = new ChildEventListener() {

            //called when item is inserted and for every item when listener is attached
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Tenant class was used to create children of the Tenant node so we can deserialize back to Tenant object
                dataSnapshot.getValue(Tenant.class);

                //can now add data to a list or other object for other transactions
                //in the future I may use this with an if statement to get all the roommates of the current user
                //do i have to loop through all nodes to return a single user? guessing there is come function to do this for me
            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //changes to can probably happen to anything but ID
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //still want to keep data even if user deletes app
                //will have to touch no this in term and conditions
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //should only happen if i decide to restructure the DB
            }

            //called when there is an error when making changes. usually a permissions issues
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //error handling
            }

        }; //END OF onChildEventListener

        //listener is specific to the Tenant node since it is attached to the Tenant reference variable
        //Actions outside the Tenant node will not trigger any of the above methods
        mTenetDbReference.addChildEventListener(mChildEventListener);





    } //END OF onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_home_screen, container, false);

        testButton = (Button) rootView.findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tenant tenant = new Tenant("with phone");
                tenant.setPhoneNumber("5555555555");
                mTenetDbReference.push().setValue(tenant);
            }
        });

        return rootView;
    }//END ON onCreateView





} //END OF CLASS
