package sample.pham.sang.roomrealmbenchmark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;
import sample.pham.sang.roomrealmbenchmark.dummy.DummyContent;
import sample.pham.sang.roomrealmbenchmark.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FeedRealmFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private MyFeedRealmAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FeedRealmFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FeedRealmFragment newInstance(int columnCount) {
        FeedRealmFragment fragment = new FeedRealmFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedrealm_list, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        mAdapter = new MyFeedRealmAdapter(null, mListener);
        recyclerView.setAdapter(mAdapter);

        Trace.beginSection("realm getInstance");
        Realm realm = Realm.getDefaultInstance();
        Trace.endSection();
        
        Trace.beginSection("start loading data realm");
        final RealmResults<FeedRealm> result = realm.where(FeedRealm.class).findAll();
        Trace.endSection();

        Trace.beginSection("read realm results");
        realm.copyFromRealm(result);
        Trace.endSection();

        mAdapter.setValues(result);
        result.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<FeedRealm>>() {
            @Override
            public void onChange(RealmResults<FeedRealm> feedRealms, OrderedCollectionChangeSet changeSet) {
                Trace.beginSection("bind Adapter");
                mAdapter.setValues(feedRealms);
                Trace.endSection();
            }
        });
        
//        AppExecutors.getInstance().diskIO().execute(() -> {
//            Realm realmThread = Realm.getDefaultInstance();
//            Trace.beginSection("copy to realm");
//            final RealmResults<FeedRealm> result = realmThread.where(FeedRealm.class).findAll();
//            realmThread.copyFromRealm(result);
//            Trace.endSection();
//            realmThread.close();
//        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(FeedRealm item);
    }
}
