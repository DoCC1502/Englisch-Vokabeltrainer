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


    public VokabController() {
        userAccount = new UserAccount();
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel(this);
        vFrame = new VokabFrame(homemenuPanel, this);
        vFrame.setVisible(true);
    }
    public VokabController(UserAccount userAccount) {
        this.userAccount = userAccount;
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel(this);
        vFrame = new VokabFrame(homemenuPanel, this);
        vFrame.setVisible(true);
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

    public VokabFrame getVFrame() {
        return vFrame;
    }
}
