'use client'
import Link from "next/link";
import { useEffect } from "react";
import { useRouter } from "next/navigation";
import Script from "next/script";

export default function Home() {
  const router = useRouter();
  useEffect(() => {
    router.push('/kakao')
  }, [])

  return (
    <main>
      {/* <span>스켈레톤 코드</span>
      <br></br>
      <Link href="/kakao">카카오 간편로그인</Link>
      <br />
      <Link href="/login">6자리로그인</Link> <br></br>
      <Link href="/login/register">닉네임</Link> <br></br>
      <Link href="/login/register/withdrawal">출금계좌등록</Link> <br></br>
      <Link href="/login/register/deposit">입금계좌등록</Link> <br></br>
      <Link href="/login/register/welcome">웰컴</Link> <br></br>
      <Link href="/transaction/withdraw">거래내역 조회 (출금 계좌)</Link> <br></br>
      <Link href="/transaction/deposit">거래내역 조회 (저축 계좌)</Link> <br></br>
      <Link href="/main">챌린지</Link> <br></br>
      <Link href="/feed">피드</Link> <br></br>
      <Link href="/write/receipt">피드 작성하기</Link> <br></br>
      <Link href="/myreceipt">내 영수증 보기</Link> <br></br> */}
    </main>
  )
}
