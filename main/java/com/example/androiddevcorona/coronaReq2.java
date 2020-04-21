package com.example.androiddevcorona;

public class coronaReq2 extends BaseReq {

    public coronaReq2listener listener;
    public interface coronaReq2listener{
        void coronaReqdone(String result);







    }


    public coronaReq2(coronaReq2listener listener){
        this.listener = listener;

    }


    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php?rapidapi-key=08ce889c3emshc741b13c3e2385fp1da0cdjsn483f402d5e6a";

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.coronaReqdone(result);
    }
}
