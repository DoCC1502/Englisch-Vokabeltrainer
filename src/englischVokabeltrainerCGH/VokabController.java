package englischVokabeltrainerCGH;
import englischVokabeltrainerCGH.model.*;
import englischVokabeltrainerCGH.view.*;
/**
 * Diese Klasse repräsentiert den Vokabeltrainer.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabController {

    


    private UserAccount userAccount;
    private VokabTrainer vTrainerModel;
    private HomemenuPanel homemenuPanel;
    private VokabFrame vFrame;
    private SettingsPanel vSettings;
    private LoginPanel vLogin;
    private FavPanel vFav;
    private VokabTrainerPanel vTrainer;
    private UploadPanel vUpload;
    private ResultPanel vResult;
    private StatistikPanel vStatistik;

    public VokabController() {
        userAccount = new UserAccount();
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel();
        vFrame = new VokabFrame(homemenuPanel, this);
        vSettings = new SettingsPanel(this);
        vLogin = new LoginPanel(this);
        vFav = new FavPanel(this);
        vTrainer = new VokabTrainerPanel(this);
        vUpload = new UploadPanel(new UploadVokabelFile(new VokabelLoader()));
        vResult = new ResultPanel(new Result());
        vStatistik = new StatistikPanel(userAccount.getVokabelStatistik());
    }



    public FavouriteList getFavouriteList() {
        return userAccount.getFavouriteList();
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void handleLogin(String username, String level) {}

    public static void main(String[] args) {
        new VokabController();

    }
}
