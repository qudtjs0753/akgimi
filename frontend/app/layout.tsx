"use client";
import { useEffect, useState } from "react";
import "../styles/globals.css";
import type { Metadata } from "next";
import Head from "next/head";
import { Inter } from "next/font/google";
import styled from "styled-components";
const inter = Inter({ subsets: ["latin"] });

// export const metadata: Metadata = {
//   title: "Create Next App",
//   description: "Generated by create next app",
// };

const Centering = styled.div`
  display: flex;
  justify-content: center;
`;
const FixedWidth = styled.div`
  width: 500px;
  min-height: 700px;
  @media (max-width: 500px) {
    /* 화면 너비가 500px 이하가 되면 요소 너비를 100%로 고정*/
    width: 100%;
  }
`;

// 모바일 세로 사이즈에 맞게 주소창 제외하고 세로 화면 계산하여 맞추기
function setScreenSize() {
  let vh = window.innerHeight;
  const layout = document.querySelector("#layout") as HTMLElement;
  if (layout) {
    layout.style.setProperty("height", `${vh}px`);
  }
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  // 모바일 세로 사이즈에 맞게 주소창 제외하고 세로 화면 계산하여 맞추기
  function setScreenSize() {
    let vh = window.innerHeight;
    const layout = document.querySelector("#layout") as HTMLElement;
    if (layout.style) {
      layout.style.setProperty("height", `${vh}px`);
    }
  }

  useEffect(() => {
    setScreenSize();
  }, []);

  return (
    <html lang="ko-KR" suppressHydrationWarning={true}>
      <head></head>
      <body className={inter.className} suppressHydrationWarning={true}>
        <Centering>
          <FixedWidth id="layout">
            {children}
          </FixedWidth>
        </Centering>
      </body>
    </html>
  );
}
