package com.example.cansis20;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramOutcomesFragment extends Fragment {

    TextView deptvison,deptmission,deptprofile,deptpeo,deptpo,deptpso;

    public ProgramOutcomesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_program_outcomes, container, false);

        deptvison = view.findViewById(R.id.deptvision);
        deptmission = view.findViewById(R.id.deptmission);
        deptprofile = view.findViewById(R.id.deptprofile);
        deptpeo = view.findViewById(R.id.deptpeo);
        deptpso = view.findViewById(R.id.deptpso);
        deptpo = view.findViewById(R.id.deptpo);

        String branch = SharedPrefManager.getInstance(this.getContext()).getBranch();

        switch(branch){

            case "cse":
                deptvison.setText(this.getString(R.string.csevision));
                deptmission.setText(this.getString(R.string.csemission));
                deptprofile.setText(this.getString(R.string.cseprofile));
                deptpso.setText(this.getString(R.string.csepso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.csepeo));
            break;

            case "ise":
                deptvison.setText(this.getString(R.string.isevision));
                deptmission.setText(this.getString(R.string.isemission));
                deptprofile.setText(this.getString(R.string.iseprofile));
                deptpso.setText(this.getString(R.string.isepso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.isepeo));
                break;

            case "ece":
                deptvison.setText(this.getString(R.string.ecvision));
                deptmission.setText(this.getString(R.string.ecmission));
                deptprofile.setText(this.getString(R.string.ecprofile));
                deptpso.setText(this.getString(R.string.ecpso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.ecpeo));
                break;
            case "me":
                deptvison.setText(this.getString(R.string.mevision));
                deptmission.setText(this.getString(R.string.memission));
                deptprofile.setText(this.getString(R.string.meprofile));
                deptpso.setText(this.getString(R.string.mepso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.mepeo));
                break;

            case "ee":
                deptvison.setText(this.getString(R.string.eevision));
                deptmission.setText(this.getString(R.string.eemission));
                deptprofile.setText(this.getString(R.string.eeprofile));
                deptpso.setText(this.getString(R.string.eepso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.eepeo));
                break;

            default:
                deptvison.setText(this.getString(R.string.csevision));
                deptmission.setText(this.getString(R.string.csemission));
                deptprofile.setText(this.getString(R.string.cseprofile));
                deptpso.setText(this.getString(R.string.csepso));
                deptpo.setText(this.getString(R.string.csepo));
                deptpeo.setText(this.getString(R.string.csepeo));
        }



        return view;
    }
}
