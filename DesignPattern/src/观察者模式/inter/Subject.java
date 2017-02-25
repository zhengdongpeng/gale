package 观察者模式.inter;

/**
 * 主题接口
 * @author zdp
 *
 */
public interface Subject {
		public void registerObserver(Observer o);
		public void removeObserver(Observer o);
		public void notifyObserver();
}
