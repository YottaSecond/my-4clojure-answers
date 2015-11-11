(ns my-4clojure-answers.core)

;;1
(= true true)

;;2
(= 4 (- 10 (* 2 3)))

;;3
(= "HELLO WORLD" (.toUpperCase "hello world"))

;;4
(= (list :a :b :c) '(:a :b :c))

;;5
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4 (conj '(3 4) 2 1)))

;;6
(= [:a :b :c] (vec '(:a :b :c)) (vector :a :b :c))

;;7
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

;;8
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

;;9
(= #{1 2 3 4} (conj #{1 4 3} 2))

;;10
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

;;11
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

;;12
(= 3 (first '(3 2 1)))
(= 3 (first [2 3 4]))
(= 3 (last (list 1 2 3)))

;;13
(= [20 30 40] (rest [10 20 30 40]))

;;14
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

;;15
(= ((partial * 2) 2) 4)
(= ((partial * 2) 3) 6)
(= ((partial * 2) 11) 22)
(= ((partial * 2) 7) 14)

;;16
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")
(= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!")
(= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!")

;;17
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;;18
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;;19
;;it's easieer to use reverse, but this occurred to me first
(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 1)
          (first seq)
          (recur (rest seq))))) [1 2 3 4 5]) 5)
(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 1)
          (first seq)
          (recur (rest seq))))) '(5 4 3)) 3)

(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 1)
          (first seq)
          (recur (rest seq))))) ["b" "c" "d"]) "d")

;;20
;;basically same solution as last - could have used reverse and second to be concise
;;could easily expand this function to be nth-from-last

(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 2)
          (first seq)
          (recur (rest seq))))) (list 1 2 3 4 5)) 4)

(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 2)
          (first seq)
          (recur (rest seq))))) ["a" "b" "c"]) "b")

(= ((fn
      [seq]
      (loop [seq seq]
        (if (= (count seq) 2)
          (first seq)
          (recur (rest seq))))) [[1 2] [3 4]]) [1 2])
