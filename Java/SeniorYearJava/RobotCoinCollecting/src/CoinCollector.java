/*
 * Daniel DelyMcShane
 * CS486
 * HW1: Coin-Collecting Problem
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class CoinCollector {

	public static void main(String[] args) throws FileNotFoundException {

		// read map from file for testing
		double[][] map = new double[6][7];
		Scanner s = new Scanner(new File("map.txt"));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = s.nextInt();
			}
		}

		// print out map
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " | ");
			}
			System.out.println();
			System.out.println("---------------------------------------");

		}

		// get result of efficient algorithm for max coins
		double result = maxCoins(map);
		System.out.println("Efficient algorithm: " + result);
		s.close();

		generateRandomMap(6, 6);

		double[][] genMap = generateRandomMap(6, 7);
	}

	// n = row, m = column
	public static double maxCoins(double[][] coins) {

		int n = coins.length;
		int m = coins[0].length;
		// initialize result matrix to 0
		double[][] result = new double[n][m];
		result[1][1] = coins[1][1];

		for (int j = 2; j < m; j++) {
			result[1][j] = result[1][j - 1] + coins[1][j];
		}

		for (int i = 2; i < n; i++) {
			result[i][1] = result[i - 1][1] + coins[i][1];

			for (int j = 2; j < m; j++) {
				result[i][j] = Math.max(result[i - 1][j] + coins[i][j], result[i][j - 1] + coins[i][j]);

			}
		}

		System.out.println("\n========================\n");
		System.out.println("Result Matrix of Efficient Algorithm:\n");
		for (int i = 0; i < result.length; i++) {

			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " | ");

			}
			System.out.println();
			System.out.println("---------------------------------------");
		}

		return result[n - 1][m - 1];
	}

	public static double[][] generateRandomMap(int rows, int columns) {
		double[][] map = new double[rows][columns];

		// values to be used in map, add extra zeroes to prevent flooding map
		// with coins and easy to debug
		double[] values = { 0, 0, 0, 0, .5, 1, 2, 5 };

		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = values[rand.nextInt(8)];
			}
		}

		return map;
	}

}