package windowETH.windowETH;

import org.web3j.crypto.Bip39Wallet;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class walletCreate {

	public void run() throws IOException, CipherException, InterruptedException, ExecutionException  {
		
		System.out.println("Creating new account");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter new password");
		
		String walletPassword = br.readLine();
		
		
		/* file location */
		File walletDirectory = new File(); // Choose file path
		Bip39Wallet walletName = WalletUtils.generateBip39Wallet(walletPassword, walletDirectory);
		System.out.println("wallet location " + walletDirectory + " / " + walletName);
		
		Credentials credentials = WalletUtils.loadBip39Credentials(walletPassword, walletName.getMnemonic());
		
		String accountAdress = credentials.getAddress();
		System.out.println("Account address: " + credentials.getAddress());
		ECKeyPair privateKey = credentials.getEcKeyPair();
		String seedphrase = walletName.getMnemonic();
		System.out.println("Account details:");
		System.out.println("Your new account : " + credentials.getAddress());
		System.out.println("Mnemonic code: " + walletName.getMnemonic());
		System.out.println("Private Key: " + privateKey.getPrivateKey().toString(16));
		System.out.println("Public Key: " + privateKey.getPublicKey().toString(16));
	}
	

}
