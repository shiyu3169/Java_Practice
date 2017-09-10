;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname hw1) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;; assignment 1
;; pair p043
;; wright steven
;; wrights
;; Wang Shiyu
;; shiyu

;; Problem 1
;; a maze is one of
;; - (make-maze string maze maze)
;; - string
(define-struct maze (prompt yes no))
(define m0 (make-maze "do you want to go left?"
                      (make-maze "do you want to go left?"
                                 (make-maze "do you want to go left?"
                                            "you found an exit!"
                                            "you found an exit!")                                 
                                 "you found an exit!")
                      "you found an exit!"))

(define m1 (make-maze "do you want to go left?"
                      "you found an exit!"
                      (make-maze "do you want to go left?"
                                 "you found an exit!"
                                 "you found an exit!")))

;; template for maze
#;(define (maze-temp m)
    (cond
      [(string? m) ...]
      [else ...(maze-prompt m)...
            ...(maze-yes m)...
            ...(maze-no m)...]))

;; longest-path : maze -> [ListOf string]
;; follows the output of the longest path
(define (longest-path m)
  (cond [(string? m) (list m)]
        [(> (length (longest-path (maze-yes m)))
            (length (longest-path (maze-no m))))
         (cons (maze-prompt m) (longest-path (maze-yes m)))]
        [else
         (cons (maze-prompt m) (longest-path (maze-no m)))]))

(check-expect (longest-path m0)
              (list
               "do you want to go left?"
               "do you want to go left?"
               "do you want to go left?"
               "you found an exit!"))

(check-expect (longest-path m1)
 (list "do you want to go left?" "do you want to go left?" "you found an exit!"))

;; all-yes : maze -> [ListOf string]
;; produces a list of all prompts and reward if you only choose yes
(define (all-yes m)
  (cond [(string? m) (list m)]
        [else
         (cons (maze-prompt m) (all-yes (maze-yes m)))]))

(check-expect (all-yes m1) (list "do you want to go left?"
                                 "you found an exit!"))
(check-expect (all-yes m0) (list "do you want to go left?" 
                                 "do you want to go left?"
                                 "do you want to go left?"
                                 "you found an exit!"))

;; flip : maze -> maze
;; produces a new maze where all answers are reversed
(define (flip m)
  (cond [(string? m) m]
        [else
         (make-maze (maze-prompt m) (flip (maze-no m)) (flip (maze-yes m)))]))

(check-expect (flip m0) (make-maze "do you want to go left?"
                                   "you found an exit!"
                                   (make-maze "do you want to go left?"     
                                              "you found an exit!"
                                              (make-maze "do you want to go left?"
                                                         "you found an exit!"
                                                         "you found an exit!"))))
(check-expect (flip m1) (make-maze "do you want to go left?"
                                   (make-maze "do you want to go left?"
                                              "you found an exit!"
                                              "you found an exit!")
                                   "you found an exit!"))

;; Problem 2

;; compute the distance between the two given points
;; dist: Posn Posn -> Number
(define (dist p1 p2)
  (sqrt (+ (sqr (- (posn-x p1) (posn-x p2)))
           (sqr (- (posn-y p1) (posn-y p2))))))
 
;; examples
(check-expect (dist (make-posn 2 3) (make-posn 5 3)) 3)
(check-expect (dist (make-posn 1 1) (make-posn 4 5)) 5)

;; template for [ListOf X]
#; (define (template-ListOf x)
     (cond [(empty? x) ...]
           [else ...]))

;; total-distance-acc : [Listof Posn] -> Number
;; that computes the total distance by accumulating the total distance traveled
;; so far as it traverses over the list of Posns
(define (total-distance-acc lop)
  (local ((define (total-acc lop acc)
            (cond [(empty? (rest lop)) acc]
                  [else (total-acc (rest lop) 
                                   (+ (dist (first lop) (second lop)) acc))])))
          (cond [(<= 2 (length lop)) (total-acc lop 0)]
                [else (error "total-distance-acc: " 
                             "lop must have 2 or more posns")])))
(check-expect (total-distance-acc (list (make-posn 0 0) (make-posn 10 0))) 10)
(check-expect (total-distance-acc (list (make-posn 0 10) (make-posn 10 10)
                                        (make-posn 10 20) (make-posn 20 20)))
              30)
(check-error (total-distance-acc (list (make-posn 0 0)))
             "total-distance-acc: lop must have 2 or more posns")

;; has-loop? : [Listof Posn] -> boolean
;; produces true if a posn is visited more than once
(define (has-loop? lop)
  (local ((define (loop-check remaining done)
            (cond [(empty? remaining) false]
                  [else (or (member? (first remaining) done)
                            (loop-check (rest remaining)
                                        (cons (first remaining) done)))])))
    (cond [(<= 2 (length lop)) (loop-check (rest lop) (list (first lop)))]
          [else (error "has-loop?: " 
                       "lop must have 2 or more posns")])))

(check-expect (has-loop? (list (make-posn 0 0)
                              (make-posn 20 20)
                              (make-posn 0 0)))
              true)
(check-expect (has-loop? (list (make-posn 0 10)
                              (make-posn 10 10)
                              (make-posn 100 100)))
              false)

(check-error (has-loop? (list (make-posn 0 0)))
             "has-loop?: lop must have 2 or more posns")

;; all-visited : [Listof Posn] -> [Listof Posn]
;; produce a list of all unique posn in list
(define (all-visited lop)
  (local ((define (check remaining done)
            (cond [(empty? remaining) done]
                  [(member? (first remaining) done) (check (rest remaining) done)]
                  [else (check (rest remaining) (cons (first remaining) done))])))
    (cond [(<= 2 (length lop)) (check (rest lop) (list (first lop)))]
          [else (error "all-visited: " "lop must have 2 or more posns")])))

(check-expect (all-visited (list (make-posn 0 0) (make-posn 1 1)))
              (list (make-posn 1 1) (make-posn 0 0)))

(check-expect (all-visited (list (make-posn 0 0)
                                 (make-posn 1 1)
                                 (make-posn 2 2)
                                 (make-posn 1 1)))
              (list (make-posn 2 2)
                    (make-posn 1 1)
                    (make-posn 0 0)))

(check-error (all-visited (list (make-posn 0 0)))
             "all-visited: lop must have 2 or more posns")

;; Problem 3

;; a vehicle is one of
;; - (make-cars num num boolean) 
;; - (make-bus num num num num)
;; - (make-truck num num num num)
(define-struct cars (tank mpg trailer))
(define-struct bus (tank mpg capacity load))
(define-struct truck (tank mpg capacity load))

(define cars0 (make-cars 15 32 false))
(define cars1 (make-cars 17 17 true))

(define bus0 (make-bus 30 15 40 1))
(define bus1 (make-bus 30 15 40 40))

(define truck0 (make-truck 30 15 4 1))
(define truck1 (make-truck 30 15 1 1/2))

;; template
#;(define (v-template v)
     (cond [(cars? v) ...]
           [(bus? v) ...]
           {else ...}))

;; computeToll : vehicle number -> number
;; computes toll given vehicle and number of miles traveled
(define (computeToll v miles)
  (cond [(and (cars? v) (cars-trailer v)) (* .35 miles)]
        [(cars? v) (* .25 miles)]
        [(bus? v) (+ (* .35 miles) (* .2 (bus-load v)))]
        [else (+ (* .4 miles) (* .05 (floor (truck-load v))))]))

(check-expect (computeToll cars0 1) .25)
(check-expect (computeToll cars1 1) .35)
(check-expect (computeToll bus0 1) .55)
(check-expect (computeToll bus1 1) 8.35)
(check-expect (computeToll truck0 1) .45)
(check-expect (computeToll truck1 1) .4)