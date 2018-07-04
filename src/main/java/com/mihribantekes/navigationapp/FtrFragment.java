package com.mihribantekes.navigationapp;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mihribantekes.navigationapp.model.PersonelModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FtrFragment extends Fragment {


    public FtrFragment() {
        // Required empty public constructor
    }


    private ListView lvPersonel;// listview tanımlama

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // oluşturulduğunda görünebilmesi için onCreate View
        // hazır metodu içerisine classın kendine ait fragmentın tanımladık
        View v = inflater.inflate(R.layout.fragment_ftr, container, false);

        new JSONTask().execute("https://api.myjson.com/bins/3jp6j");// JSONTask classımızı çağırdık

        //ImageLoader Kütüphanesinin Hazır Fonksiyonları
        DisplayImageOptions defaultOptions = new  DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder( getActivity()).defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        lvPersonel = (ListView) v.findViewById(R.id.lvPersonel);// tanımladığımız listviewi xml e tanıttık.


        return v;
    }



    public class JSONTask extends AsyncTask<String,String,List<PersonelModel>>// JSON parse etme classı
    {

        @Override
        protected List<PersonelModel> doInBackground(String... params) {

            //İnternet Bağlantı Satırlar
            HttpURLConnection connection = null;
            BufferedReader reader=null;
            InputStream stream;
            StringBuffer buffer;
            try {
                URL url = new URL(params[0]); //bağlantı
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                //Json içerisindeki veriyi okuyor
                stream = connection.getInputStream();//veriyi aldık
                reader = new BufferedReader(new InputStreamReader(stream)); //okuma yapıyor
                buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null)
                {
                    buffer.append(line);// buffera attık

                }

                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);

                JSONArray parentArray = parentObject.getJSONArray("personeller"); // json dizisini alır
                //StringBuffer finalBufferedData = new StringBuffer();
                List<PersonelModel> personelModelList = new ArrayList<>(); //JSON veriler için liste oluşturduk

                for(int i=0; i<parentArray.length(); i++)

                {
                    JSONObject finalobject = parentArray.getJSONObject(i); //dizinin elemanları için

                    //set fonksiyonlarıyla alınan veriler personelmodele kaydediliyor
                    PersonelModel personelModel = new PersonelModel();
                    personelModel.setUnvan(finalobject.getString("unvan"));
                    personelModel.setAd(finalobject.getString("ad"));
                    personelModel.setSoyad(finalobject.getString("soyad"));
                    personelModel.setOda(finalobject.getString("oda"));
                    personelModel.setResim(finalobject.getString("resim"));



                    //her biri eleman bloğunu olan personelmodeli  ModelListe ekliyoruz
                    personelModelList.add(personelModel);


                }

                return personelModelList;

                //hazır try-catch fonksiyonları
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null)
                {connection.disconnect();}
                try {
                    if(reader != null){
                        reader.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }



        @Override
        protected void onPostExecute(List<PersonelModel> result) {
            super.onPostExecute(result);
            // tvData.setText(result);
            // TODO need to set to the list
            PersonelAdapter adapter = new PersonelAdapter(getActivity(),R.layout.row, result);// adapter oluşturma
            lvPersonel.setAdapter(adapter);// adapterle listviewi bağladık

        }
    }



    public class PersonelAdapter extends ArrayAdapter//adapter classı
    {
        private List<PersonelModel> personelModelList;//PersonelModel classımızdan yeni modellist oluşturduk
        private int resource;
        private LayoutInflater inflater;
        public PersonelAdapter(Context context, int resource, List<PersonelModel> objects) {
            super(context, resource, objects);
            personelModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // metodun yaptığı iş satırları çizdirmek
            //position = çizdirilecek olan satırın sıra sayısı
            //contertview = ListView i gösterirken her satırı baştan oluşturmak yerine ekranı dolduracak
            //minumum sayda satır oluşturup aşağıdaki diğer satırlar için üst satırlarn görselini kullanır.
            //ilk sayfa üzerindeki satırlarda contertview null ken diğer sayfadaki ilk satırda null olmaz satır sıfırdan oluşturulmaz


            ViewHolder holder = null;// viewholder kurulumu
            if(convertView == null)
            {
                holder = new ViewHolder();//viewholderı sıfırdan oluşturma
                convertView = inflater.inflate(resource, null);//satır görseli oluşturma
                holder.ivResim = (ImageView)convertView.findViewById(R.id.ivResim);
                holder.tvAd = (TextView)convertView.findViewById(R.id.tvAd);
                holder.tvSoyad = (TextView)convertView.findViewById(R.id.tvSoyad);
                holder.tvOda = (TextView)convertView.findViewById(R.id.tvOda);
                holder.tvUnvan = (TextView)convertView.findViewById(R.id.tvUnvan);

                convertView.setTag(holder);
            }
            else
            {
                //viewholder ı zaten daha önceden oluşturulan viewholder a eşitleme
                holder = (ViewHolder) convertView.getTag();
            }




            final ProgressBar progressBar = (ProgressBar)convertView.findViewById(R.id.progressBar);

            // Then later, when you want to display image
            ImageLoader.getInstance().displayImage("http://i.hizliresim.com/go7bpQ.jpg", holder.ivResim, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String s, View view) {
                    progressBar.setVisibility(View.GONE);
                }
            });


            // parse edilen verileri elemanlara verme
            holder.tvUnvan.setText("Unvan:   " + personelModelList.get(position).getUnvan());
            holder.tvAd.setText("Ad:  " + personelModelList.get(position).getAd());
            holder.tvSoyad.setText("Soyad:   " + personelModelList.get(position).getSoyad());
            holder.tvOda.setText("Oda:    " + personelModelList.get(position).getOda());




            return convertView;
        }
    }


    class ViewHolder//öğeleri her seferinde tek tek bulmak yerine bir kere bulup kaydetmeyi sağlıyor

    {

        private ImageView ivResim;
        private TextView tvAd;
        private TextView tvSoyad;
        private TextView tvOda;
        private TextView tvUnvan;

    }

}
