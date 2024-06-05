package lab_padroes_projeto_java.design_patterns.gof.singleton;

public class SingletonUsage {
	public static void main(String[] args) {

		SingletonLazy lazyOne = SingletonLazy.getInstancia();
		System.out.println("Primeira instanciação de SingletonLazy " + lazyOne);
		SingletonLazy lazyTwo = SingletonLazy.getInstancia();
		System.out.println("Segunda instanciação de SingletonLazy " + lazyTwo);
		System.out.println("lazyOne é igual a lazyTwo? " + (lazyOne == lazyTwo));

		SingletonEager eagerOne = SingletonEager.getInstancia();
		System.out.println("\nPrimeira instanciação de SingletonEager " + eagerOne);
		SingletonEager eagerTwo = SingletonEager.getInstancia();
		System.out.println("Segunda instanciação de SingletonEager " + eagerTwo);
		System.out.println("eagerOne é igual a eagerTwo? " + (eagerOne == eagerTwo));

		SingletonLazyHolder lazyHolderOne = SingletonLazyHolder.getInstancia();
		System.out.println("\nPrimeira instanciação de SingletonLazyHolder " + lazyHolderOne);
		SingletonLazyHolder lazyHolderTwo = SingletonLazyHolder.getInstancia();
		System.out.println("Segunda instanciação de SingletonLazyHolder " + lazyHolderTwo);
		System.out.println("lazyHolderOne é igual a lazyHolderTwo? " + (lazyHolderOne == lazyHolderTwo));

	}

}
